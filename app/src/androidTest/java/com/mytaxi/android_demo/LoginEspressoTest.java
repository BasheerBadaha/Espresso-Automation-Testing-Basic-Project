package com.mytaxi.android_demo;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.AuthenticationActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.Matchers.allOf;

/**
 *  @ Author  Basheer Badaha
 */

@RunWith(AndroidJUnit4.class)
public class LoginEspressoTest {

    @Rule
    public ActivityTestRule<AuthenticationActivity> rule =
            new ActivityTestRule<>(AuthenticationActivity.class);

    /**
     * Test Case for testing successful login for a given username and password.
     * Will test the following:
     * - Display username TextField
     * - Display password TextFiled
     * - Set username and password and read the user entered value from TextField
     * - Display Login Button
     * - Check correct click() action for login button
     * - Check successful login attempt
     * - Check that AuthenticationActivity has finished
     */

    @Test
    public void loginSucceeded() throws InterruptedException {


        // View user name field
        ViewInteraction userNameView = onView(allOf(withId(R.id.edt_username)));
        // check if user name field is displayed
        userNameView.check(matches((isDisplayed())));
        // Fill the correct user name value in the field
        userNameView.perform(typeText(TestConstantUtils.correctUserName));


        // View password field
        ViewInteraction passwordView = onView(allOf(withId(R.id.edt_password)));
        // Check if password field is displayed
        passwordView.check(matches((isDisplayed())));
        // Fill the correct password value in the password field
        passwordView.perform(typeText(TestConstantUtils.correctPassword), closeSoftKeyboard());


        // View login button
        ViewInteraction loginButton = onView(allOf(withId(R.id.btn_login)));
        // Check if login button is displayed
        loginButton.check(matches((isDisplayed())));
        // Check if login button is clickable
        loginButton.check(matches((isClickable())));
        // Click on login button
        loginButton.perform(click());


        // Wait for 2 seconds until the login executed
        Thread.sleep(2000);


        // Assertion to check if 'AuthenticationActivity' has finished and so, login has succeeded
        assertTrue(rule.getActivity().isFinishing());
    }

    /**
     * Login test case 2
     * Test Case for testing Failed login for a wrong username and password.
     * Will test the following:
     * - Display username TextField
     * - Display password TextFiled
     * - Set username and password and read the user entered value from TextField
     * - Display Login Button
     * - Check correct click() action for login button
     * - Check Failed login attempt
     * - Check that the sankeBar appeared with the failed message 'Login failed'
     */

    @Test
    public void loginFailedWrongPasswordAndUserName() throws InterruptedException {


        // View user name field
        ViewInteraction userNameView = onView(allOf(withId(R.id.edt_username)));
        // check if user name field is displayed
        userNameView.check(matches((isDisplayed())));
        // Fill the wrong user name value in the field
        userNameView.perform(typeText(TestConstantUtils.wrongUserName));


        // View password field
        ViewInteraction passwordView = onView(allOf(withId(R.id.edt_password)));
        // Check if password field is displayed
        passwordView.check(matches((isDisplayed())));
        // Fill the wrong password value in the password field
        passwordView.perform(typeText(TestConstantUtils.wrongPassword), closeSoftKeyboard());


        // View login button
        ViewInteraction loginButton = onView(allOf(withId(R.id.btn_login)));
        // Check if login button is displayed
        loginButton.check(matches((isDisplayed())));
        // Check if login button is clickable
        loginButton.check(matches((isClickable())));
        // Click on login button
        loginButton.perform(click());


        // Wait for 2 seconds until the login executed
        Thread.sleep(2000);

        // Check if the snackbar appears for failed login and contains 'Login failed' text
        onView(allOf(withId(android.support.design.R.id.snackbar_text),
                withText("Login failed"))).check(matches(isDisplayed()));
    }

    /**
     * Login test case 3
     * Test Case for testing Failed login for a correct username and wrong password.
     * Will test the following:
     * - Display username TextField
     * - Display password TextFiled
     * - Set username and password and read the user entered value from TextField
     * - Display Login Button
     * - Check correct click() action for login button
     * - Check Failed login attempt
     * - Check that the sankeBar appeared with the failed message 'Login failed'
     */

    @Test
    public void LoginFailedCorrectUserNameAndWrongPassword() throws InterruptedException {


        // View user name field
        ViewInteraction userNameView = onView(allOf(withId(R.id.edt_username)));
        // check if user name field is displayed
        userNameView.check(matches((isDisplayed())));
        // Fill the correct user name value in the field
        userNameView.perform(typeText(TestConstantUtils.correctUserName));


        // View password field
        ViewInteraction passwordView = onView(allOf(withId(R.id.edt_password)));
        // Check if password field is displayed
        passwordView.check(matches((isDisplayed())));
        // Fill the wrong password value in the password field
        passwordView.perform(typeText(TestConstantUtils.wrongPassword), closeSoftKeyboard());


        // View login button
        ViewInteraction loginButton = onView(allOf(withId(R.id.btn_login)));
        // Check if login button is displayed
        loginButton.check(matches((isDisplayed())));
        // Check if login button is clickable
        loginButton.check(matches((isClickable())));
        // Click on login button
        loginButton.perform(click());


        // Wait for 2 seconds until the login executed
        Thread.sleep(2000);

        // Check if the snackbar appears for failed login and contains 'Login failed' text
        onView(allOf(withId(android.support.design.R.id.snackbar_text),
                withText("Login failed"))).check(matches(isDisplayed()));
    }

    /**
     * Login test case 4
     * Test Case for testing Failed login for a correct username and empty password.
     * Will test the following:
     * - Display username TextField
     * - Display password TextFiled
     * - Set username and read the user entered value from TextField
     * - Display Login Button
     * - Check correct click() action for login button
     * - Check Failed login attempt
     * - Check that the sankeBar appeared with the failed message 'Login failed'
     */

    @Test
    public void LoginFailedCorrectUserNameAndEmptyPassword() throws InterruptedException {


        // View user name field
        ViewInteraction userNameView = onView(allOf(withId(R.id.edt_username)));
        // check if user name field is displayed
        userNameView.check(matches((isDisplayed())));
        // Fill the correct user name value in the field
        userNameView.perform(typeText(TestConstantUtils.correctUserName));


        // View password field
        ViewInteraction passwordView = onView(allOf(withId(R.id.edt_password)));
        // Check if password field is displayed
        passwordView.check(matches((isDisplayed())));
        // Fill the wrong password value in the password field
        passwordView.perform(typeText(""), closeSoftKeyboard());


        // View login button
        ViewInteraction loginButton = onView(allOf(withId(R.id.btn_login)));
        // Check if login button is displayed
        loginButton.check(matches((isDisplayed())));
        // Check if login button is clickable
        loginButton.check(matches((isClickable())));
        // Click on login button
        loginButton.perform(click());


        // Wait for 2 seconds until the login executed
        Thread.sleep(2000);

        // Check if the snackbar appears for failed login and contains 'Login failed' text
        onView(allOf(withId(android.support.design.R.id.snackbar_text),
                withText("Login failed"))).check(matches(isDisplayed()));
    }
}
