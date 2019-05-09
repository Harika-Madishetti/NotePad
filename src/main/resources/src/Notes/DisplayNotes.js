import React from 'react';
import axios from 'axios';
import {NoteBox} from "./NoteBox";

class DisplayNotes extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            notes: [],
            selected: ''
        }
    }

    componentDidMount() {
        axios.get('/notes').then((response) => {
            this.setState({
                notes: response.data
            })
        })
    }

    render() {
        return (
            <div className="notes">
                {this.state.notes.map((notes, index) => (
                    <NoteBox key={index} notes={notes}>
                    </NoteBox>
                ))}
            </div>
        )
    }
}

export default DisplayNotes