# Android - TODOs


The most critical skill in Android development is handling **Configuration Changes** (like rotating the screen). In Android, when you rotate your phone, the system literally **destroys** your Activity and creates a brand new one. If you have a counter or text input, it disappears.

**The Counter Challenge — Surviving Destruction.**

---

### Phase 1: The "Broken" App

First, let's build a simple UI with a counter to see it fail.

1. Open `MainActivity.kt`.
2. Create a simple counter variable.
3. Add a Button that increments the counter and a Text label to show it.

**The Code (Compose):**

```kotlin
@Composable
fun CounterScreen() {
    var count = 0 // Local variable - This will "die" on rotation
    
    Column {
        Text(text = "Count: $count")
        Button(onClick = { count++ }) {
            Text("Increment")
        }
    }
}

```

**Test it:** Increment the count to 5, then **rotate your emulator**. The count will reset to 0. This is the "Lifecycle Trap."

---

### Phase 2: The "Architect's" Solution (ViewModel)

To fix this, we use a **ViewModel**. The ViewModel is special because it is scoped to the *user's intent*, not the Activity's life. It stays in memory while the Activity is being destroyed and recreated.

1. **Add the Dependency:** Open `build.gradle.kts (Module:app)` and add:
`implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")`
2. **Create the ViewModel:**

```kotlin
class MainViewModel : ViewModel() {
    // State remains alive during rotation
    var count by mutableStateOf(0)
        private set

    fun increment() {
        count++
    }
}

```

---

### Phase 3: Wiring it Together

Now, update your `MainActivity` to use this ViewModel.

```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Get the ViewModel (it survives rotation!)
            val viewModel: MainViewModel = viewModel()
            
            Column {
                Text(text = "Count: ${viewModel.count}")
                Button(onClick = { viewModel.increment() }) {
                    Text("Increment and Rotate Me!")
                }
            }
        }
    }
}

```

---

### Phase 4: The "Save State" (Advanced)

What if the user leaves the app and the system kills it to save battery? The ViewModel dies too. For this, we use `rememberSaveable`.

**The Task:** Add an `TextField` to your screen.

* Use `var text by rememberSaveable { mutableStateOf("") }`.
* This uses the `onSaveInstanceState` lifecycle hook under the hood to save small amounts of data to a bundle on the disk.

---

### 🏁 Today's "Architect" Goals:

* [ ] **Trigger a Re-creation:** Rotate the device and observe why local variables are dangerous.
* [ ] **Implement a ViewModel:** Learn how to separate "Data" from "UI" so the data survives Activity destruction.
* [ ] **Understand Scope:** Realize that the ViewModel lives as long as the Activity *exists in the task manager*, even if it's currently being "recreated."


### Next Steps

**Implementing a "Timer" in the ViewModel next? This is a great way to see how a background process in the ViewModel continues even while the Activity is "Restarting."**
