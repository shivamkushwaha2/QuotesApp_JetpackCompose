package com.insoft.firstcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.insoft.firstcompose.R
import com.insoft.firstcompose.Routes
import com.insoft.firstcompose.components.ButtonComponent
import com.insoft.firstcompose.components.CheckBoxComponent
import com.insoft.firstcompose.components.ClickableLoginTextComponent
import com.insoft.firstcompose.components.DividerTextComponent
import com.insoft.firstcompose.components.HeadingText
import com.insoft.firstcompose.components.InputBox
import com.insoft.firstcompose.components.NormalText
import com.insoft.firstcompose.components.PasswordInputBox

@Composable
fun SignUpScreen(navController: NavHostController) {
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 40.dp)
        ) {
            NormalText("Hey There,")
            Spacer(modifier = Modifier.height(10.dp))
            HeadingText("Create An Account")
            Spacer(modifier = Modifier.height(30.dp))
            InputBox("Full Name", Modifier, painterResource(id = R.drawable.baseline_person_24))
            Spacer(modifier = Modifier.height(10.dp))
            InputBox(
                "Last Name", painterResource = painterResource(id = R.drawable.baseline_person_24)
            )
            Spacer(modifier = Modifier.height(10.dp))
            InputBox("Email", painterResource = painterResource(id = R.drawable.baseline_email_24))
            Spacer(modifier = Modifier.height(10.dp))
            PasswordInputBox(
                "Password", painterResource = painterResource(id = R.drawable.baseline_lock_24)
            )
            Spacer(modifier = Modifier.height(5.dp))

            CheckBoxComponent(
                "I agree to the Terms & Conditions",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            ButtonComponent(
                text = "Sign Up",
                modifier = Modifier.fillMaxWidth().clickable {
                    navController.navigate("ShowQuoteList"){
                        popUpTo(Routes.signup){
                            inclusive = true
                        }
                    }
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            DividerTextComponent(Modifier)

            Spacer(modifier = Modifier.height(20.dp))

            ClickableLoginTextComponent(navController = navController)


        }


    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    SignUpScreen(navController = rememberNavController())
}
