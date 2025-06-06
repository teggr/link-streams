package news.inboxed.app.web.subscriptions.components;

import j2html.tags.specialized.HeaderTag;

import static dev.rebelcraft.j2html.bootstrap.Bootstrap.*;
import static dev.rebelcraft.j2html.bootstrap.Bootstrap.col;
import static j2html.TagCreator.*;
import static j2html.TagCreator.h2;

public class SubscriptionsActionBar {

public static HeaderTag subscriptionsActionBar(String refreshUrl, String addSubscriptionUrl) {

    return header().withClasses(row).with(

        div().withClass(col_2).with(h2("Subscriptions").withClasses(px_3)),

        div().withClasses(col, pt_1).with(

            a().withClasses(btn, btn_secondary).with(span().withClasses("bi", "bi-arrow-clockwise"))
                .withHref(refreshUrl),

            form().withMethod("post").withAction(addSubscriptionUrl).withClasses(d_inline_flex, mb_0).with(

                div().withClasses(form_control, me_2).with(input().withType("text").withName("subscription")),

                button().withType("submit").withClasses(btn, btn_primary).withText("Add"))
            
            // form().withMethod("post").withAction(updateFeedsUrl).withClasses(d_inline_flex, mb_0).with(

            //     button().withType("submit").withClasses(btn, btn_primary).withText("Run Update Job"))

        ));

  }

}
