package com.mytaxi.android_demo;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNot.not;


/**
 * @ Author  Basheer Badaha
 */
@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchEspressoTest {

    // Log Tag
    public static final String Search_Espresso_Test = "SearchEspressoTest";

    /**
     * Rule annotation which gives functional testing for a single activity
     * Tests access the activities using the rule (MainActivity)
     */
    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule =
            new ActivityTestRule<>(MainActivity.class, false, true);


    /**
     * Auto-complete search Test Case
     * Test Case for testing a successful search in the aut-complete and select a driver.
     * <p>
     * Will test the following:
     * <p>
     * - Display search TextField
     * - Search 2 letters 'sa'
     * - Display 'Sarah Friedrich' in the results
     * - Check correct click() action for 'Sarah Friedrich'
     * - Select 'Sarah Friedrich'
     * - Check that 'Sarah Friedrich' profile's opens
     * - Click on call
     * - Check if the number of 'Sarah Friedrich' is copied and entered in the dialer
     */
    @Test
    public void autoCompleteSearchSmallLetters() throws InterruptedException {

        // View text search field (auto-complete)
        // withId(R.id.my_view) is a ViewMatcher
        ViewInteraction textSearch = onView(withId(R.id.textSearch));
        //Click in text search field
        textSearch.perform(click())
                // Add 'sa' in the search field
                .perform(typeText("sa"));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Check the text Search, type sa to start searching");


        // Check that " Sarah Friedrich "  suggestion is displayed.
        onView(withText("Sarah Friedrich"))
                .inRoot(withDecorView(not(is(mainActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich is Displayed");

        // Tap on the suggestion.
        // Click on 'Sarah Friedrich'
        onView(withText("Sarah Friedrich"))
                .inRoot(withDecorView(not(is(mainActivityRule.getActivity().getWindow().getDecorView()))))
                .perform(click());

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Click on Sarah Friedrich");

        /**
         * here we are checking that we reached the drivers profile 'Sarah Friedrich' by checking:
         *
         * - Drivers address is viewed correctly
         * - Drivers name is viewed correctly
         * - Drivers profile is displayed
         * - Call button is displayed
         */
        //Check the driver's address is appearing correctly
        ViewInteraction driverAddressText = onView(
                allOf(withId(R.id.textViewDriverLocation), withText("2297 bahnhofstraﬂe")));
        driverAddressText.check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich's address is : 2297 bahnhofstraﬂe ");

        //Check the driver's name is appearing correctly
        ViewInteraction driverNameTextView = onView(
                allOf(withId(R.id.textViewDriverName), withText("Sarah Friedrich")));
        driverNameTextView.check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich name is displayed on her profile");

        //Check the driver's image is appearing correctly
        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageViewDriverAvatar)));
        imageView.check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich's avatar is displayed on her profile");

        // Click on call button for this driver
        // Should redirect the user to the dialer with the selected driver's number
        onView(withId(R.id.fab))
                //check if the call button is displayed
                .check(matches(isDisplayed()))
                //Click on call button
                .perform(click());

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Start Calling Sarah Friedrich");
    }

    /**
     * Auto-complete search Test Case
     * Test Case for testing a successful search in the aut-complete and select a driver.
     * <p>
     * Will test the following:
     * <p>
     * - Display search TextField
     * - Search 2 letters 'sa'
     * - Display 'Sarah Friedrich' in the results
     * - Check correct click() action for 'Sarah Friedrich'
     * - Select 'Sarah Friedrich'
     * - Check that 'Sarah Friedrich' profile's opens
     * - Click on call
     * - Check if the number of 'Sarah Friedrich' is copied and entered in the dialer
     */

    @Test
    public void autoCompleteSearchCapitalLetters() throws InterruptedException {

        // View text search field (auto-complete)
        // withId(R.id.my_view) is a ViewMatcher
        ViewInteraction textSearch = onView(withId(R.id.textSearch));
        //Click in text search field
        textSearch.perform(click())
                // Add 'SA' in the search field
                .perform(typeText("SA"));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Check the text Search, type sa to start searching");


        // Check that " Sarah Friedrich "  suggestion is displayed.
        onView(withText("Sarah Friedrich"))
                .inRoot(withDecorView(not(is(mainActivityRule.getActivity().getWindow().getDecorView()))))
                .check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich is Displayed");

        // Tap on the suggestion.
        // Click on 'Sarah Friedrich'
        onView(withText("Sarah Friedrich"))
                .inRoot(withDecorView(not(is(mainActivityRule.getActivity().getWindow().getDecorView()))))
                .perform(click());

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Click on Sarah Friedrich");

        /**
         * here we are checking that we reached the drivers profile 'Sarah Friedrich' by checking:
         *
         * - Drivers address is viewed correctly
         * - Drivers name is viewed correctly
         * - Drivers profile is displayed
         * - Call button is displayed
         */
        //Check the driver's address is appearing correctly
        ViewInteraction driverAddressText = onView(
                allOf(withId(R.id.textViewDriverLocation), withText("2297 bahnhofstraﬂe")));
        driverAddressText.check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich's address is : 2297 bahnhofstraﬂe ");

        //Check the driver's name is appearing correctly
        ViewInteraction driverNameTextView = onView(
                allOf(withId(R.id.textViewDriverName), withText("Sarah Friedrich")));
        driverNameTextView.check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich name is displayed on her profile");

        //Check the driver's image is appearing correctly
        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageViewDriverAvatar)));
        imageView.check(matches(isDisplayed()));

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Sarah Friedrich's avatar is displayed on her profile");

        // Click on call button for this driver
        // Should redirect the user to the dialer with the selected driver's number
        onView(withId(R.id.fab))
                //check if the call button is displayed
                .check(matches(isDisplayed()))
                //Click on call button
                .perform(click());

        //type logs to monitor the test
        Log.i(Search_Espresso_Test, "Start Calling Sarah Friedrich");

    }

}
