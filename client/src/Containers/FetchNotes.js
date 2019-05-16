import React from 'react';
import axios from 'axios';
import NoteBox from "../Components/NoteBox";


class FetchNotes extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            notes: [],
        }
    }


    componentDidMount() {
        axios.get('http://localhost:8080/notes').then((response) => {
            const newNotes = response.data.map(notes => {
                return {
                    id: notes.id,
                    title: notes.title,
                    content: notes.content
                };
            }).reverse()
            const newState = Object.assign({}, this.state, {
                notes: newNotes
            });
            this.setState(newState)
        })
            .catch(error => (error));
    }

    render() {
        return (
            <div className="notes">
                {this.state.notes.map((notes, index) => (
                    <NoteBox key={index} notes={notes} noteSelected={this.noteSelected}
                             isClicked={this.state.isClicked}>
                    </NoteBox>
                ))}
            </div>
        )
    }
}

export default FetchNotes