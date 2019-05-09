import React, {Component} from 'react';
import Header from "./Header/Header"
import NoteForm from "./Notes/NoteForm";
import DisplayNotes from "./Notes/DisplayNotes";

class App extends Component {

    render() {
        return (
            <div className="app">
                <Header/>
                <NoteForm/>
                <DisplayNotes/>
            </div>
        );
    }
}

export default App;
