import React from 'react';
import Header from './Header';
import renderer from 'react-test-renderer';


test('test Header component',()=>{
    const component = renderer.create(
        <Header>NotePad
        </Header>
    )
    let tree = component.toJSON();
    expect(tree).toMatchSnapshot();
})