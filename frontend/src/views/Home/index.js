import React from 'react';
import listItems from "../../items.json";
import List from 'components/List/index';
import "./index.css";

export default class Home extends React.Component {
    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>
                <p className="text-center text-secondary text-sm font-italic">
                    (this is a <strong>class-based</strong> application)
                </p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        <div className="col-sm">
                            <List
                                title="List Items"
                                items={listItems}
                            ></List>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}