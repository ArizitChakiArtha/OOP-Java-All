# Compile Verification

The repository source files were checked with the Java compiler using the following command:

```bash
find . -path '*/src/main/java/*' -name '*.java' > target/sources.txt
javac -encoding UTF-8 -d target/manual-classes @target/sources.txt
```

Result: all Java source files compiled successfully in the generation environment.

Note: Maven was not installed in the generation environment, so the local verification used `javac`. The repository still includes a complete Maven multi-module `pom.xml` structure and `.github/workflows/maven.yml` for GitHub Actions CI.
