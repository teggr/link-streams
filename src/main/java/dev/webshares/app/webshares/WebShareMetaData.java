package dev.webshares.app.webshares;

import java.time.Instant;

import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Embedded.OnEmpty;

public record WebShareMetaData(String title, Instant createdDate,
    @Embedded(onEmpty = OnEmpty.USE_NULL, prefix = "OG_") OpenGraphData openGraphData,
    @Embedded(onEmpty = OnEmpty.USE_NULL, prefix = "TWITTER_") TwitterMetaData twitterMetaData,
    @Embedded(onEmpty = OnEmpty.USE_NULL, prefix = "ARTICLE_") ArticleMetaData articleMetaData) {

  public WebShareMetaData {
    if (createdDate == null) {
      createdDate = Instant.now();
    }
  }

}
