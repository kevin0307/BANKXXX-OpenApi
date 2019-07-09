#!/usr/bin/env python
import codecs
import os

from setuptools import setup, find_packages

description = "Python SDK for Bankxxx REST And Websocket API (https://www.bank.xxx)"

here = os.path.abspath(os.path.dirname(__file__))


def read(*parts):
    with codecs.open(os.path.join(here, *parts), 'r') as fp:
        return fp.read()


setup(
    name="bankxxx",
    version="1.1",
    author="Bankxxx",
    author_email="pip@bank.xxx",
    description=description,
    long_description=read('README.md'),
    long_description_content_type="text/markdown",
    url="https://github.com/kevin0307/BANKXXX-OpenApi/tree/master/sdk/python",
    packages=find_packages(),
    install_requires=['requests', 'six', 'twisted', 'autobahn', 'pyopenssl', 'service_identity'],
    classifiers=[
        "Programming Language :: Python :: 3",
        "License :: OSI Approved :: MIT License",
        "Operating System :: OS Independent",
    ],
)
