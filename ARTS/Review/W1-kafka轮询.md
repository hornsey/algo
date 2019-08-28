
# Kafka轮询和Awaitality

[Reactive Kafka Poller and Awaitility](https://medium.com/@pp62091/reactive-kafka-poller-and-awaitility-4306bc03fee7)

文件记录了作者在开发订单执行服务项目中，使用Kafka的心得体会。
 
 1.Kafka的java客户端非线程安全，如果并行处理时间，需确保同步访问。

 2.kafka提交时有commitSync 和 commitAsync 两个版本，如要确保性能，使用异步提交，不用等待和重试。

 3.session.timeout.ms 可配置Kafka的心跳超时时间；
 max.poll.interval.ms 可配置线程死亡检测时间。
 
 4.Kafka不保证分区排序，需自行检查。
 
 5.处理失败的消息可以推送到DLQ(死信队列)并继续前进，手动解决DLQ。确保DLQ保留期足够长。
 
 6.创建标识符（如UUID)区分每条记录。
 
 
 ## 待读 
  
  Kafka处理死信队列构建可靠回收机制
  
 [Building Reliable Reprocessing and Dead Letter Queues with Apache Kafka](https://eng.uber.com/reliable-reprocessing/)
