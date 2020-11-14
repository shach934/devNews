#devNews
This is a project developed for a forum API using Spring with Postgres database 

There are three main classes: 
1. Article
2. Comments
3. Topics

The class Article created the following Rest APIs for forum: 

| HTTP Method | HTTP Path | Action |
| ------------|-----------|--------|
| `GET` |`/articles` | return all articles. |
| `GET` | `/articles/{id}` | return a specific article based on the provided id.|
| `POST`| `/articles` | create a new article.|
| `PUT` | `/articles` | update the given article.|
| `DELETE` | `/articles` | delete the given article.|
|`GET` |`/articles?topicId={topicId}` | return all articles with the given `topicId`. |


The class Comments created the following Rest APIs: 

| HTTP Method | HTTP Path | Action |
| ------------|-----------|--------|
| `GET` |`/comments` | return all comments. |
| `GET` | `/comments?articleId={articleId}` | return all comments with the given `articleId`.|
| `POST`| `/comments` | create a new comment.|
| `PUT` | `/comments` | update the given comment.|
| `DELETE` | `/comments` | delete the given comment.|

The class Topics created the following Rest APIs:

| HTTP Method | HTTP Path | Action |
| ------------|-----------|--------|
| `GET` |`/topics` | return all topics. |
| `GET` | `/topics?articleId={articleId}` | return all topics related with the given `articleId`.|
| `POST`| `/topics` | create a new topic.|
| `PUT` | `/topics` | update the given topic.|
| `DELETE` | `/topics` | delete the given topic.|