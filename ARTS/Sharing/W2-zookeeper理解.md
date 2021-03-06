# Zookeeper的理解

## 概述
Zookeeper是一个分布式协调处理器，具有可扩展性和可靠性等优点，一般用于分布式系统中的消息队列和服务调度。
Zookeeper主要提供一致性和分区容忍，在高可用性方面表显稍差。它的一致性主要通过Fast Paxos算法和ZAB算法实现。

## Paxos算法
Paxos算法是一种实现分布式一致性的算法，通常用来描述解决拜占庭将军问题。它通过选举机制实现多台主机构成的集群的一致性。
Paxos算法主要包括2个过程：
1）Parpare阶段。此阶段各个有选举权的角色可以提出提案，发送给其他选举者。每个提案带着一个提案号。选举者会记录一个自己接收到的最大提案号，如果收到的提案比记录的最大提案号小，则忽略或返回错误，否则可以接受。
2）Accept阶段。当提案者收到半数以上的提案回复时，就认为提案通过，发送accept请求。每个选择者仍会比较请求中的提案号和自己记录的最大提案号比较，比最大提案号小则忽略或返回错误，等于或大于最大提案号则接受。当某个提案者获得半数以上的accept 确认，则当选为leader。

## Fast Paxos算法
Zookeeper对Paxos算法进行了性能改进。Zookeeper在选举Leader时使用，保障系统的分布式一致性状态。

## ZAB算法
ZAB算法全称为Zookeeper Atomic Broadcast, ZooKeeper原子广播协议。该协议主要用于处理Client请求的分布式事务，保障系统的数据一致性。
当Client向某台Server发送读请求时，Server会直接回复。如果Client发送的是写请求，则Server先转发给Leader，Leader进行广播给所以有投票权的Server，当投票权超过半数时，Leader广播所有的Server处理写事务，并返回给开始处理请求的Server，该Server再回复给Client。

## 其他
1. Zookeeper主要提供一致性，可用性相对差些。每个写事务及选举leader时，为了保障一致性，会暂停服务（很短暂）。
2. Zookeeper集群必选保障有过半有选举权的主机工作，否则即使leader没有挂掉，集群也不能提供服务。
3. 为了保障集群可用，集群有多台主机，分布在3个及以上机房上，最多主机的机房也不要超过半数主机。







