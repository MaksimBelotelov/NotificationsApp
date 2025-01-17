const TableRowItem = (props) => {
    
    return(
        <tr>
            <th scope='row'>{props.note.id}</th>
            <th>{props.note.title}</th>
            <th>{props.note.date}</th>
        </tr>
    );
}

export default TableRowItem;