class Twitter {
    private static int timestamp = 0;

    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    // Maps userId to their set of followees
    private final Map<Integer, Set<Integer>> followees;
    // Maps userId to the head of their tweet linked list (most recent tweet first)
    private final Map<Integer, Tweet> tweets;

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        // Prepend new tweet so the list stays ordered from most recent to oldest
        newTweet.next = tweets.get(userId);
        tweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        // Max-heap comparing tweets by timestamp descending
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // Include the user's own tweets
        Tweet userHead = tweets.get(userId);
        if (userHead != null) {
            maxHeap.offer(userHead);
        }

        // Include tweets from all followed users
        Set<Integer> followed = followees.get(userId);
        if (followed != null) {
            for (int followeeId : followed) {
                // Ensure a user doesn't get added twice if they followed themselves
                if (followeeId != userId) {
                    Tweet head = tweets.get(followeeId);
                    if (head != null) {
                        maxHeap.offer(head);
                    }
                }
            }
        }

        // Merge up to 10 most recent tweets across all followed feeds
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Tweet curr = maxHeap.poll();
            feed.add(curr.id);

            if (curr.next != null) {
                maxHeap.offer(curr.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followees.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followed = followees.get(followerId);
        if (followed != null) {
            followed.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */