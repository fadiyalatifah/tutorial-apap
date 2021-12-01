import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
import DeleteIcon from '@mui/icons-material/Delete';
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import { IconButton } from "@material-ui/core";

const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete } = props;
    // const { item, onChange, isShopList } = props;

    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Price: ${price}`}</p>
            <p>{`Description: ${description}`}</p>
            <p>{`Category: ${category}`}</p>
            <p>{`Stok: ${quantity}`}</p>
            <Button action={handleEdit}>
                Edit
            </Button>
            {/* <CustomIconButton isShopList={isShopList} inCart={inCart} handleChange={handleChange}/> */}
        </div>
    );
};
export default Item;

// function CustomIconButton({ isShopList, inCart, handleChange }) {
//     if (isShopList) {
//         if (inCart) {
//             return null;
//         }
//         return (
//             <IconButton onClick={handleChange}>
//                 <AddShoppingCartIcon />
//             </IconButton>);
//     } else {
//         return (
//             <IconButton onClick={handleChange}>
//                 {inCart ? <DeleteIcon /> : <AddShoppingCartIcon />}
//             </IconButton>);
//     }
// }
