#!/bin/bash

echo "Enter the Commit Title: "
read ct

git add .
git commit -m '$ct'
git push
