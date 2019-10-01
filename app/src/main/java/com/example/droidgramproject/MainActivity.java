package com.example.droidgramproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Post[] posts = new Post[5];
    int current = 0;

    TextView nameTextView;
    ImageView postImageView;
    TextView numLikesTextView;
    TextView descriptionTextView;
    TextView commentsTextView;
    EditText commentText;

    Post currentPost = posts[current];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTextView = findViewById(R.id.droidName);
        postImageView = findViewById(R.id.droidImage);
        numLikesTextView = findViewById(R.id.numLikes);
        descriptionTextView = findViewById(R.id.description);
        commentsTextView = findViewById(R.id.comments);
        commentText = findViewById(R.id.comment);

        Post myPost = new Post("Coach A", R.drawable.droid1, "Just joined Code Next!");

        posts[current] = myPost;

        updateCurrentPost();
    }

    public void updateCurrentPost(){
        currentPost = posts[current];
        //Update Name Text
        nameTextView.setText(currentPost.getDroidName());
        //Update Image
        postImageView.setImageResource(currentPost.getDroidImage());
        //Update number of likes
        numLikesTextView.setText(currentPost.getNumLikes()+" likes");
        //Update description
        descriptionTextView.setText(currentPost.getDescription());
        //Update comments
        String comments = "";
        ArrayList<String> commentsArray = currentPost.getComments();
        for(int i=0; i<commentsArray.size(); i++){
            comments += commentsArray.get(i) + "\n";
        }
        commentsTextView.setText(comments);
    }

    public void addLike(View v){
        currentPost = posts[current];
        int currentLikes = currentPost.getNumLikes() + 1;
        currentPost.setNumLikes(currentLikes);
        Log.i("num", String.valueOf(currentPost.getNumLikes()));
        numLikesTextView.setText(currentPost.getNumLikes()+" likes");
    }

    public void submitComment(View v){
        String comment = commentText.getText().toString();
        currentPost = posts[current];
        ArrayList comments = currentPost.getComments();
        comments.add(comment);
        currentPost.setComments(comments);
        updateCurrentPost();
        commentText.setText("");
    }
}

