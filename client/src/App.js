import './App.css';
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

const appendNote = () => {
  const temp = {id: 1110, title: "Из функции", date: "1234"};
  
  setItems([...items, temp]);
}

  return (
    <div className='container mt-5'>
      <div className='card'>
        <div className='card-header'>
          <h1>Список напоминаний</h1>
        </div>
        <div className='card-body'>
          <TableView data={items}/>
          <div>
            <button className='btn btn-primary'
            onClick={appendNote}>
              Новое напоминание
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;