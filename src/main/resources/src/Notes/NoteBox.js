import React from 'react'
import {Edit} from "../Icons/Edit";
import NoteModal from "./NoteModal";

class NoteBox extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            isClicked: false
        }
    }

    noteSelected = (notes) => {
        this.setState({
            isClicked: true
        })
    }

    render() {
        const {notes} = this.props
        const hasNotes = (notes.title || notes.content)
        return (
            <div className="note">
                <div onClick={() => this.noteSelected(notes)}>
                    <Edit/>
                    {this.state.isClicked && <NoteModal notes={notes}/>}
                </div>
                {
                    hasNotes ? (
                        <div>
                            {
                                notes.title && <h1>{notes.title}</h1>
                            }
                            {
                                notes.content && <pre>{notes.content}</pre>
                            }
                        </div>
                    ) : (
                        <div className="empty">
                            Empty Note
                        </div>
                    )
                }
            </div>
        )
    }
}

export default NoteBox




