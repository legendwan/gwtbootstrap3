package org.gwtbootstrap3.client.ui;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasName;
import org.gwtbootstrap3.client.ui.base.ComplexWidget;
import org.gwtbootstrap3.client.ui.constants.ElementTags;
import org.gwtbootstrap3.client.ui.constants.InputType;
import org.gwtbootstrap3.client.ui.constants.Styles;

/**
 * @author Joshua Godi
 */
public class Input extends ComplexWidget implements HasEnabled, HasInputType, HasPlaceholder, HasFormValue, HasName, HasAllKeyHandlers {
    private static final String MIN = "min";
    private static final String MAX = "max";
    private static final String DISABLED = "disabled";

    public Input() {
        setElement(Document.get().createElement(ElementTags.INPUT));
        addStyleName(Styles.FORM_CONTROL);
    }

    @UiConstructor
    public Input(final InputType type) {
        this();
        setType(type);
    }

    public void setMin(final String min) {
        getElement().setAttribute(MIN, min);
    }

    public void setMax(final String max) {
        getElement().setAttribute(MAX, max);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        getElement().setPropertyBoolean(DISABLED, !enabled);
    }

    @Override
    public boolean isEnabled() {
        return !getElement().getPropertyBoolean(DISABLED);
    }

    @Override
    public void setType(final InputType inputType) {
        getElement().setAttribute(TYPE, inputType.getType());
    }

    @Override
    public InputType getType() {
        if (getElement().getAttribute(TYPE) == null || getElement().getAttribute(TYPE).isEmpty()) {
            return null;
        }
        return InputType.valueOf(getElement().getAttribute(TYPE));
    }

    @Override
    public void setPlaceholder(final String placeHolder) {
        getElement().setAttribute(PLACEHOLDER, placeHolder != null ? placeHolder : "");
    }

    @Override
    public String getPlaceholder() {
        return getElement().getAttribute(PLACEHOLDER);
    }

    @Override
    public String getFormValue() {
        return InputElement.as(getElement()).getValue();
    }

    @Override
    public void setFormValue(final String value) {
        InputElement.as(getElement()).setValue(value);
    }

    @Override
    public String getName() {
        return InputElement.as(getElement()).getName();
    }

    @Override
    public void setName(final String name) {
        InputElement.as(getElement()).setName(name);
    }

    @Override
    public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
        return addDomHandler(handler, KeyDownEvent.getType());
    }

    @Override
    public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
        return addDomHandler(handler, KeyPressEvent.getType());
    }

    @Override
    public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
        return addDomHandler(handler, KeyUpEvent.getType());
    }
}
