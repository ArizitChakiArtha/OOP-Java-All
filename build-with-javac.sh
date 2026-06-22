#!/usr/bin/env bash
set -euo pipefail
mkdir -p target/manual-classes
find . -path "*/src/main/java/*" -name "*.java" > target/sources.txt
javac -encoding UTF-8 -d target/manual-classes @target/sources.txt
echo "All Java files compiled successfully with javac."
