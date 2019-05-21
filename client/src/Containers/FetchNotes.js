import React from 'react';
import NoteBox from "../Containers/NoteBox";
import {getNotes} from "../service/NotePadService";


class FetchNotes extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            notes: []
        }
    }

   componentDidMount() {
       getNotes().then(response => {
           const newNotes = response.reverse()
           this.setState({
               notes:newNotes
           })
       })
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