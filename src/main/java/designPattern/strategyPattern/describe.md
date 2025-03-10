使用策略模式可以把行为和环境分割开来。环境类Context负责查询要做什么，各种算法则在具体策略类（ConcreteStrategy）中提供。 当出现新的促销折扣或现有的折扣政策出现变化时，只需要实现新的策略类，并在客户端登记即可。
策略模式类似于枚举，把所有的可能性都罗列出来

https://blog.csdn.net/qq_51165184/article/details/123997917?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169923617716800184190215%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=169923617716800184190215&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-2-123997917-null-null.142^v96^control&utm_term=%E7%AD%96%E7%95%A5%E6%A8%A1%E5%BC%8F&spm=1018.2226.3001.4187