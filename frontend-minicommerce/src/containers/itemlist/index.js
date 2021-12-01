import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig.js";
import Button from "../../components/button";
import Modal from "../../components/modal";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import ViewStreamIcon from "@mui/icons-material/ViewStream";
import { Fab } from "@material-ui/core";
import List from "../../List";


class ItemList extends Component {
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
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearch = this.handleSearch.bind(this);

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

    handleSearch(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        this.filterData();
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
            <div className={classes.itemList}>
                <h1 className={classes.title}>
                    All Items
                </h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ?
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                            : <ViewStreamIcon />}
                    </Fab>
                </div>

                {!this.state.cartHidden ? (
                    <div className="col-sm">
                        <List
                            title="My Cart"
                            items={this.state.cartItems}
                            onItemClick={this.handleDeleteItemFromCart}
                        ></List>
                    </div>
                ) :

                    <><Button action={this.handleAddItem}>
                        Add Item
                    </Button><div>
                            <input
                                type="text"
                                name="search"
                                placeholder="Cari"
                                value={this.state.search}
                                onChange={this.handleSearch.bind(this)} />
                        </div><div>
                            {this.state.items.map((item) => (
                                <Item
                                    key={item.id}
                                    id={item.id}
                                    title={item.title}
                                    price={item.price}
                                    description={item.description}
                                    category={item.category}
                                    quantity={item.quantity}
                                    handleEdit={() => this.handleEditItem(item)} />
                            ))}
                        </div>
                        
                        <Modal
                            show={this.state.isCreate || this.state.isEdit}
                            handleCloseModal={this.handleCancel}
                            modalTitle={this.state.isCreate
                                ? "Add Item"
                                : `Edit Item ID ${this.state.id}`}
                        >
                            <form>
                                <input
                                    className={classes.textField}
                                    type="text"
                                    placeholder="Nama Item"
                                    name="title"
                                    value={this.state.title}
                                    onChange={this.handleChangeField} />
                                <input
                                    className={classes.textField}
                                    type="number"
                                    placeholder="Harga"
                                    name="price"
                                    value={this.state.price}
                                    onChange={this.handleChangeField} />
                                <textarea
                                    className={classes.textField}
                                    placeholder="Deskripsi"
                                    name="description"
                                    rows="4"
                                    value={this.state.description}
                                    onChange={this.handleChangeField} />
                                <input
                                    className={classes.textField}
                                    type="text"
                                    placeholder="Kategori"
                                    name="category"
                                    value={this.state.category}
                                    onChange={this.handleChangeField} />
                                <input
                                    className={classes.textField}
                                    type="number"
                                    placeholder="qty"
                                    value={this.state.quantity}
                                    name="quantity"
                                    onChange={this.handleChangeField} />
                                <Button action={this.state.isCreate
                                    ? this.handleSubmitItem
                                    : this.handleSubmitEditItem}
                                >
                                    Create
                                </Button>
                                <Button action={this.handleCancel}>
                                    Cancel
                                </Button>
                            </form>
                        </Modal></>
                }

            </div>
        );
    }


}
export default ItemList;