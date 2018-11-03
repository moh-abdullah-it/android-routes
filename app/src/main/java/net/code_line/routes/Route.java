package net.code_line.routes;

import android.content.Context;

import net.code.line.route.BaseRoute;

public class Route extends BaseRoute {
    /**
     * @param context
     */
    public Route(Context context) {
        super(context);
    }

    public Route mainActivity()
    {
        to(MainActivity.class);
        return this;
    }
}
