package com.insoft.firstcompose.screens

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.insoft.firstcompose.R
import com.insoft.firstcompose.Routes
import com.insoft.firstcompose.components.ButtonComponent
import com.insoft.firstcompose.components.ClickableSignUpTextComponent
import com.insoft.firstcompose.components.DividerTextComponent
import com.insoft.firstcompose.components.HeadingText
import com.insoft.firstcompose.components.InputBox
import com.insoft.firstcompose.components.NormalText
import com.insoft.firstcompose.components.PasswordInputBox
import com.insoft.firstcompose.ui.theme.StatusBarColor

@Composable
fun LoginScreen(navController: NavHostController) {
//   StatusBarColor(Color.Blue)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
        ) {

            NormalText("Hey There,")
            Spacer(modifier = Modifier.height(10.dp))

            HeadingText("Welcome Back")

            Spacer(modifier = Modifier.height(30.dp))

            InputBox("Email", painterResource = painterResource(id = R.drawable.baseline_email_24))

            Spacer(modifier = Modifier.height(10.dp))

            PasswordInputBox(
                "Password", painterResource = painterResource(id = R.drawable.baseline_lock_24)
            )
            Text(
                text = "Forgot Password?",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(
                text = "Login",
                modifier = Modifier.fillMaxWidth().clickable {
                    navController.navigate("ShowQuoteList"){
                        popUpTo(Routes.login){
                            inclusive = true
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()

            Spacer(modifier = Modifier.height(20.dp))
            ClickableSignUpTextComponent(navController)
        }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun LoginPreview() {
    LoginScreen(navController = rememberNavController())
}