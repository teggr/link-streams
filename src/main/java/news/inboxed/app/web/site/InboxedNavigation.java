package news.inboxed.app.web.site;

import static dev.rebelcraft.j2html.bootstrap.Bootstrap.*;
import static j2html.TagCreator.*;
import static j2html.TagCreator.nav;

import java.util.Map;

import j2html.tags.specialized.NavTag;

public class InboxedNavigation {

  public static NavTag inboxedNavigation(Map<String, Object> model) {

    // get urls from the model
    String homeUrl = (String) model.get("homeUrl");
    String searchUrl = (String) model.get("searchUrl");
    String username = (String) model.get("username");
    String logoutUrl = (String) model.get("logoutUrl");
    String subscriptionsUrl = (String) model.get("subscriptionsUrl");

    // external services
    String feedHubUrl = (String) model.get("feedHubUrl");
    String webSharesUrl = (String) model.get("webSharesUrl");

    return nav().withClasses(navbar, navbar_expand_lg, bg_primary_subtle, mb_4).with(

        div().withClasses(container_fluid).with(

            a().withClasses(navbar_brand, px_3).withHref(homeUrl)
              .with(
                span().withClasses("bi", "bi-inbox-fill"),
                text("Inboxed")
              ), 
            
            button().withClass(navbar_toggler).withType("button").attr("data-bs-toggle", "collapse")
                .attr("data-bs-target", "#navbarToggler").attr("aria-controls", "navbarToggler")
                .attr("aria-expanded", "false").attr("aria-label", "Toggle Navigation")
                .with(span().withClass(navbar_toggler_icon)),

            div().withClasses(collapse, navbar_collapse, d_lg_flex, justify_content_lg_between).withId("navbarToggler")
                .with(

                    div(),

                    form().withClasses(d_inline_flex, mb_0).with(

                        input().withClasses(form_control, me_2).withType("search"), button().withType("submit")
                            .withClasses(btn, btn_outline_secondary).with(span().withClasses("bi", "bi-search"))

                    ),

                    ul().withClass(navbar_nav).with(

                        li().withClasses(nav_item, dropdown).with(
                            a().withClasses(nav_link, dropdown_toggle).withText("my@email.com").withHref("#")
                                .attr("data-bs-toggle", "dropdown").attr("role", "button")
                                .attr("aria-expanded", "false"),

                            ul().withClasses(dropdown_menu).with(

                                li().with(a().withClasses(dropdown_item).withHref(homeUrl).withText("Reader")),

                                li().with(a().withClasses(dropdown_item).withHref(subscriptionsUrl).withText("Subscriptions")),

                                li().withClasses(dropdown_divider),

                                li().with(a().withClasses(dropdown_item).withHref(feedHubUrl).withText("FeedHub")),
                                li().with(a().withClasses(dropdown_item).withHref(webSharesUrl).withText("WebShares")),

                                li().withClasses(dropdown_divider),

                                li().with(a().withClasses(dropdown_item).withHref(logoutUrl).withText("Logout"))

                            ))

                    )

                )

        )

    );
  }

}
