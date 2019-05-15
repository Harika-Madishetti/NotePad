import React, {Component} from 'react';
import Header from "./Header";
import FetchNotes from "../Containers/FetchNotes";
import HandleNoteForm from "../Containers/HandleNoteForm";

class App extends Component {

    render() {

        return (
            <div className="app">
                <Header/>
                <HandleNoteForm/>
                <FetchNotes/>
            </div>
        );
    }
}

export default App;
