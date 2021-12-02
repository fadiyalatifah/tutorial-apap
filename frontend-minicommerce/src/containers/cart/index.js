import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig.js";
import ViewStreamIcon from "@mui/icons-material/ViewStream";
import { Fab } from "@material-ui/core";
import { Link } from "react-router-dom";


class Cart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            search: "",

            cartItems: [],
            cartHidden: true,
        };
        // this.handleAddItem = this.handleAddItem.bind(this);
        // this.handleCancel = this.handleCancel.bind(this);
        // this.handleClickLoading = this.handleClickLoading.bind(this);
        // this.handleChangeField = this.handleChangeField.bind(this);
        // this.handleSubmitItem = this.handleSubmitItem.bind(this);
        // this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        // this.handleSearch = this.handleSearch.bind(this);

    }
    componentDidMount() {
        this.loadData();
    }
    handleAddItem() {
        this.setState({ isCreate: true });
    }
    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }
    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }
    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
    async filterData() {
        try {
            const { data } = await APIConfig.get(`/item?title=${this.state.search}`);
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }


    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }
    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });


    };

    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);
        if (targetInd < 0) {
            newItem.inCart = true;
            newItems.push(newItem)
            this.updateShopItem(newItem, true)
        }
        this.setState({ cartItems: newItems });
    };

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.setState({ shopItems: tempShopItems });
    }

    render() {
        return (
            <div className={classes.cart}>
                <h1 className={classes.title}>
                    CART ITEMS
                </h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Link to="/">
                        <Fab variant="extended" >

                            <ViewStreamIcon />
                        </Fab>
                    </Link>
                </div>
                <div className="col-sm">
                    <Item
                        title= {this.state.title}
                        items={this.state.cartItems}
                    ></Item>
                </div>
            </div>
        );
    }
}
export default Cart;