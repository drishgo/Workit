package com.Workit.Workit.repo;

import com.Workit.Workit.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class SearchRepoImpl implements SearchRepo{
    @Value("${spring.data.mongodb.database}")
    private String databaseName;
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;



    @Override
    public List<Post> findByText(String text) {
        MongoDatabase database = mongoClient.getDatabase(databaseName);
        List<Post> posts = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection("post");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("profile", "desc", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L))));
        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));
        return posts;
    }
}
