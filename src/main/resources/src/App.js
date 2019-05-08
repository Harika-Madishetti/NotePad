import React, {Component} from 'react';
import Header from "./Header/Header"
import AddNoteForm from "./Notes/AddNoteForm";

class App extends Component {

    render() {
        console.log("in render of new app")
        return (
            <div className="app">
                <Header/>
                <AddNoteForm/>
            </div>
        );
    }
}

export default App;
