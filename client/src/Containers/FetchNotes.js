import React from 'react';
import axios from 'axios';
import NoteBox from "../Containers/NoteBox";


class FetchNotes extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            notes: []
        }
    }

   componentDidMount() {
         axios.get('http://localhost:8080/notes').then((response) => {
            const newNotes = response.data.reverse()
            this.setState({
                notes: newNotes
            })
        }).catch(error => (error));
    }

    render() {
        return (
            <div className="notes">
                {this.state.notes.map((notes, index) => (
                    <NoteBox key={index} index={index} notes={notes} noteSelected={this.noteSelected}
                             isClicked={this.state.isClicked}>
                    </NoteBox>
                ))}
            </div>
        )
    }
}

export default FetchNotes