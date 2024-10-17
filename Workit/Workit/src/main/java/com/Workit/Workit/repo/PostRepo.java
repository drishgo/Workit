package com.Workit.Workit.repo;

import com.Workit.Workit.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<Post,String> {

}
