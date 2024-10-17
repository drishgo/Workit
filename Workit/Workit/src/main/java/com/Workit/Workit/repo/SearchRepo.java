package com.Workit.Workit.repo;

import com.Workit.Workit.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String text);
}
