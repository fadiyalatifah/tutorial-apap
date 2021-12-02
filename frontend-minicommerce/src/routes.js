import React from "react";
import { Route, Switch, Redirect } from "react-router-dom";
import ItemList from "./containers/itemlist";
import Cart from "./containers/cart";

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/" component={ItemList}/>
                <Route exact path="/cart" component={Cart}/>
    
            </Switch>
        </div>
    );
};