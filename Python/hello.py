#!/usr/bin/env python3
# -*- coding: utf-8 -*-
import os                 # 提供遍历目录、拼接路径等操作系统功能
import csv                # 用于安全读取 CSV，避免自己处理换行坑
import logging            # 标准日志模块，可同时输出到文件与控制台
from datetime import datetime  # 用于给日志加时间戳

# ----------------- 日志配置 -----------------
# 日志文件名，运行目录下自动生成
LOG_FILE = 'csv_count.log'
# 配置日志级别、格式与输出位置
logging.basicConfig(
    level=logging.INFO,                     # 记录 INFO 及以上级别
    format='%(asctime)s - %(levelname)s - %(message)s',  # 时间-级别-消息
    handlers=[
        logging.FileHandler(LOG_FILE, encoding='utf-8'),  # 同时写入文件
        logging.StreamHandler()              # 同时打印到终端
    ]
)
log = logging.getLogger(__name__)  # 获取当前模块的日志记录器

# ----------------- 核心函数 -----------------
def count_csv_rows(csv_path):
    """
    统计单个 CSV 文件的行数（含表头）
    :param csv_path: 文件绝对路径
    :return: 行数 int
    """
    rows = 0
    # 以读模式打开文件，with 会自动关闭文件
    with open(csv_path, 'r', encoding='utf-8') as f:
        # 使用 csv.reader 可正确处理换行符在引号内的情况
        reader = csv.reader(f)
        for _ in reader:  # 逐行迭代
            rows += 1     # 每迭代一次行数加 1
    return rows

def main():
    """
    主入口：遍历目录 -> 过滤 csv -> 统计 -> 输出与记录
    """
    # 让用户输入要扫描的目录路径，strip 去掉首尾空格
    target_dir = input('请输入要遍历的目录路径：').strip()
    # 判断路径是否存在且是目录，不是就报错退出
    if not os.path.isdir(target_dir):
        log.error(f'路径不存在或不是目录：{target_dir}')
        return

    log.info(f'开始扫描目录：{target_dir}')
    csv_files = []  # 用来收集所有 csv 文件的绝对路径

    # os.walk 会递归遍历目录树，返回 当前路径、子目录列表、文件列表
    for root, _, files in os.walk(target_dir):
        for name in files:
            # 只保留扩展名为 .csv 的文件（忽略大小写）
            if name.lower().endswith('.csv'):
                full_path = os.path.join(root, name)  # 拼接完整路径
                csv_files.append(full_path)

    # 如果根本没找到 csv，打印提示并结束
    if not csv_files:
        log.warning('未找到任何 CSV 文件')
        return

    log.info(f'共发现 {len(csv_files)} 个 CSV 文件，开始统计行数...')
    total_rows = 0  # 用于累加所有 csv 的总行数

    # 逐个文件统计
    for csv_path in csv_files:
        try:
            count = count_csv_rows(csv_path)  # 调用函数拿到行数
            total_rows += count               # 累加到总计
            # 打印并记录结果，os.path.basename 只取文件名部分，避免路径太长
            log.info(f'{os.path.basename(csv_path)} : {count} 行')
        except Exception as e:  # 捕获文件损坏、编码错误等任何异常
            log.error(f'读取文件失败：{csv_path} -> {e}')

    # 全部处理完后输出总计
    log.info(f'所有 CSV 文件总行数：{total_rows}')

# ----------------- 脚本入口 -----------------
# 当本文件被直接运行时才执行 main()，被导入时不执行
if __name__ == '__main__':
    main()