import React from 'react'
import TableRowItem from './components/TableRowItem';

const TableView = (props) => {

    return (
        <table className='table table-hover'>
            <thead>
            <tr>
                <th scope='col'>Id</th>
                <th scope='col'>Title</th>
                <th scope='col'>Напоминание</th>
            </tr>
            </thead>
            <tbody>
                {
                    props.data.map(item => (
                        <TableRowItem note={item} /> 
                    ))
                }
            </tbody>
        </table>
      );
}

export default TableView;