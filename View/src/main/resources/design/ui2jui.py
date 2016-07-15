# -*- coding: utf-8 -*-
"""
Small tool to convert qt designer ui files to .jui format which is required
for qt to use with java language.
"""

import argparse


def convert(ui_file):
    fname = ui_file.split('.')[0] + '.jui'
        
    with open(ui_file, "r") as f:
        data = f.read()
        splitting_data = data.split('<?xml version="1.0" encoding="UTF-8"?>')[1]
        jdata = splitting_data[:18] + ' ' + 'language="jambi"' + splitting_data[18:]    

    with open(fname,'w') as fout:
        fout.write(jdata.lstrip())      


def main():
    parser = argparse.ArgumentParser(description="converter to .ui files to .jui")
    parser.add_argument('ui_file', help='ui file to be converted')
    args = parser.parse_args()
    convert(args.ui_file)

if __name__ == '__main__':
    main()