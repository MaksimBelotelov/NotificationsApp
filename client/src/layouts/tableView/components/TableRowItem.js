const TableRowItem = (props) => {
    
    return(
        <tr onClick={() => {props.removeNote(props.note.id);}}>
            <th scope='row'>{props.note.id}</th>
            <th>{props.note.title}</th>
            <th>{props.note.remind}</th>
        </tr>
    );
}

export default TableRowItem;