# retry-util

Simple java util for retry.

### Get Started

#### Add in Maven pom:
```xml
<dependencies>
    <dependency>
        <groupId>com.github.shuaicj</groupId>
        <artifactId>retry-util</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

#### Usage:
- RetryUtil.retryForever(...)
- RetryUtil.retryUntil(...)
- RetryUtil.retry(...)
