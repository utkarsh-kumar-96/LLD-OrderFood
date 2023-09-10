package utkarsh.OrderFood.models;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.UUID;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Rating {
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Integer> ratings = new ArrayList<Integer>();
	private Integer ratingSum = 0;
	
	public Double getAvgRating() {
		OptionalDouble avg = ratings.stream().mapToDouble(Integer::doubleValue).average();
		return avg.orElse(0.0);
	}

	public void addRatingAndComment(String comment, Integer rating) {
		ratings.add(rating);
		comments.add(new Comment.CommentBuilder().id(UUID.randomUUID().toString()).comment(comment).build());
		ratingSum += rating;
	}
}