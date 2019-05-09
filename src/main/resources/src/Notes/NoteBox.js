import React from 'react'
import {EditIcon} from "./EditIcon";


export const NoteBox = (noteBox, index) => {
    const hasNotes = noteBox
    return (
        <div className="note">
            <div>
                <EditIcon/>
            </div>
            {
                hasNotes ? (
                    <div>
                        {
                            noteBox.notes.title && <h1>{noteBox.notes.title}</h1>
                        }
                        {
                            noteBox.notes.content && <pre>{noteBox.notes.content}</pre>
                        }
                    </div>
                ) : (<div className="empty">
                    Empty Note
                </div>)
            }
        </div>
    )

}


