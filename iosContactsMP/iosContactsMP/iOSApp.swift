import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        DiHelperKt.doInitDi()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}