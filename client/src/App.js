import './App.css';
import FormNewItem from './layouts/formNewItem/FormNewItem';
import TableView from './layouts/tableView/TableView';
import React, { useState} from 'react';


function App() {

  const [items, setItems] = useState(
    [
      {id: 1, title: "Новый заголовок1", date: "01.01.2026"},
      {id: 2, title: "Новый заголовок2", date: "02.02.2027"},
      {id: 3, title: "Новый заголовок3", date: "03.03.2028"}
    ]
  );

const appendNote = (title, date) => {
  const currentId = items.length + 1;
  const temp = {id: currentId, title: title, date: date};
  setItems([...items, temp]);
}

const removeNote = (id) => {
  setItems(items.filter(item => item.id != id ));
}

  return (
    <div className='container mt-5'>
      <div className='card'>
        <div className='card-header'>
          <h1>Список напоминаний</h1>
        </div>
        <div className='card-body'>
          <TableView data={items} removeNote={removeNote} />
          <FormNewItem appendNote={appendNote}/>
        </div>
      </div>
    </div>
  );
}

export default App;