package Mongodb;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * MongoUtils
 *
 * @author zrj
 * @since 2022/3/29
 **/
public class MongoDBTest {
    /**
     * 获取连接，无需密码
     */
    @Test
    public void getMongoConnectionByAddress() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");

            MongoCollection<Document> col = mongoDatabase.getCollection("col");
            FindIterable<Document> documents = col.find();
            System.out.println("col documents : " + documents);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 获取连接，需密码
     */
    @Test
    public void getMongoConnectionByUser() {
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            // ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("localhost", 27017);
            List<ServerAddress> addrs = new ArrayList<>();
            addrs.add(serverAddress);
            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
            List<MongoCredential> credentials = new ArrayList<>();
            credentials.add(credential);
            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");
            System.out.println("Connect to database successfully，mongoDatabase：" + mongoDatabase);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 创建集合
     */
    @Test
    public void createCollection() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");
            mongoDatabase.createCollection("test1");
            System.out.println("test集合创建成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 获取集合
     */
    @Test
    public void getCollection() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功，collection：" + collection);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 插入文档
     */
    @Test
    public void insertMany() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");


            //插入文档
            //1. 创建文档 org.bson.Document 参数为key-value的格式
            //2. 创建文档集合List<Document>
            //3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
            Document document = new Document("title", "MongoDB").append("description", "database").append("likes", 100).append("by", "Fly");
            Document document1 = new Document("title", "MongoDB1").append("description1", "database").append("mike", 100).append("by", "Fly");
            Document document2 = new Document("title", "MongoDB2").append("description2", "database").append("jack", 100).append("by", "Fly");

            List<Document> documents = new ArrayList<>();
            documents.add(document);
            documents.add(document1);
            documents.add(document2);
            collection.insertMany(documents);
            System.out.println("文档插入成功");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 检索所有文档
     */
    @Test
    public void find() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //检索所有文档
            //1.获取迭代器FindIterable<Document>
            //2.获取游标MongoCursor<Document>
            //3.通过游标遍历检索出的文档集合
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            System.out.println("获取游标成功，mongoCursor：" + mongoCursor);
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
            System.out.println("检索所有文档完成");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 更新文档
     */
    @Test
    public void updateMany() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
            System.out.println("集合 test 选择成功");

            //更新文档   将文档中likes=100的文档修改为likes=200
            collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            System.out.println("获取游标成功，mongoCursor：" + mongoCursor);
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
            System.out.println("更新文档完成");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * 删除文档
     */
    @Test
    public void findOneRemove() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = MongoClients.create("mongodb://localhost");
            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mongodb");
            System.out.println("Connect to database successfully");
            MongoCollection<Document> collection = mongoDatabase.getCollection("test1");
            System.out.println("集合 test 选择成功");

            //删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("likes", 200));
            //删除所有符合条件的文档
            collection.deleteMany(Filters.eq("likes", 200));
            //检索查看结果
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            System.out.println("获取游标成功，mongoCursor：" + mongoCursor);
            while (mongoCursor.hasNext()) {
                System.out.println(mongoCursor.next());
            }
            System.out.println("删除文档完成");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}

