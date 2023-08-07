package paulo.jorge.app.presenter.game.tictactoe

sealed class UserAction {
    object PlayAgainButtonClicked: UserAction()
    data class BoardTapped(val cellNo: Int): UserAction()
}