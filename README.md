# Spring 声明式事物

## 相关源码
```java
// org.springframework.transaction.interceptor.TransactionAspectSupport
// 捕获异常后处理
completeTransactionAfterThrowing(txInfo, ex);
```

- 判断是否需要回滚
```java
// 有配置事务 && 是否回滚异常
txInfo.transactionAttribute != null && txInfo.transactionAttribute.rollbackOn(ex)
```

- 具体方法
```java
public boolean rollbackOn(Throwable ex) {
    RollbackRuleAttribute winner = null;
    int deepest = Integer.MAX_VALUE;

    if (this.rollbackRules != null) {
        for (RollbackRuleAttribute rule : this.rollbackRules) {
            int depth = rule.getDepth(ex);
            if (depth >= 0 && depth < deepest) {
                deepest = depth;
                winner = rule;
            }
        }
    }

    // User superclass behavior (rollback on unchecked) if no rule matches.
    if (winner == null) {
        // 没有配置rollbackFor时执行以下方法
        return super.rollbackOn(ex);
    }
    
    return !(winner instanceof NoRollbackRuleAttribute);
}
```

- 有配置rollbackFor = Exception.class时;
```java
// class:RuleBasedTransactionAttribute
return !(winner instanceof NoRollbackRuleAttribute);
```

- 没有配置rollbackFor时;
```java
// class:DefaultTransactionAttribute
// 默认回滚RuntimeException及其子类异常
return (ex instanceof RuntimeException || ex instanceof Error);
```
