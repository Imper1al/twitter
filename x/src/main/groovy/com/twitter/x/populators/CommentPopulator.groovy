package com.twitter.x.populators

import com.twitter.x.entities.Comment
import org.springframework.stereotype.Component

@Component
class CommentPopulator {

    CommentPopulator() {}

    Comment populateComment(Comment comment, Comment existingComment) {

        existingComment.setContent(comment.getContent())

        return existingComment
    }
}
